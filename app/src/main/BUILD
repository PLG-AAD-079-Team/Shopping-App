load("@rules_jvm_external//:defs.bzl", "artifact")

android_binary(
    name ="app",
    srcs = glob(["java/com/philipademba/takehome/*.java"]),
    custom_package = "com.example.bazel",
    manifest = "java/AndroidManifest.xml",
    resource_files = glob(["res/**"]),
    visibility = ["//src/test:__subpackages__"],
    deps = [
        artifact("androidx.appcompat:appcompat"),
        artifact("androidx.annotation:annotation"),
    ],
)
