package com.philipademba.takehome.presentation.ui.maps.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.preference.PreferenceManager
import android.view.LayoutInflater
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView


@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("InflateParams")
@Composable
fun MapViewer() {
    val permissionState =
        rememberMultiplePermissionsState(
            permissions = listOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )
    val ctx: Context = LocalContext.current.applicationContext

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { _, e ->
            run {
                if (e == Lifecycle.Event.ON_RESUME) {
                    permissionState.launchMultiplePermissionRequest()
                }
            }

        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })
    permissionState.permissions.forEach {
        when (it.permission) {
            Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                when {
                    it.hasPermission -> {
                        AndroidView(
                            factory = { context ->
                                val view = LayoutInflater.from(context)
                                    .inflate(
                                        com.philipademba.takehome.R.layout.main_map_view,
                                        null,
                                        false
                                    )

                                Configuration.getInstance()
                                    .load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
                                val map =
                                    view.findViewById<MapView>(com.philipademba.takehome.R.id.mapView)
                                map.setTileSource(TileSourceFactory.MAPNIK)
                                map.setBuiltInZoomControls(true)
                                map.setMultiTouchControls(true)
                                val mapController = map.controller
                                mapController.setZoom(15)
                                val startPoint = GeoPoint(0.514277, 35.269779)
                                
                                mapController.setCenter(startPoint)
                                view // return the view
                            },
                            update = {

                            }
                        )
                    }

                    it.shouldShowRationale -> {
                        Text("Waiting for permissions")
                    }
                }
            }
        }
    }

}