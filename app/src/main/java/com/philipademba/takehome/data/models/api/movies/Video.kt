

package com.philipademba.takehome.data.models.api.movies

import androidx.compose.runtime.Immutable

@Immutable
data class Video(
  val id: String,
  val name: String,
  val site: String,
  val key: String,
  val size: Int,
  val type: String
)
