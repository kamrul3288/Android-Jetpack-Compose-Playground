package com.iamkamrul.composeplayground

object Dependencies {

    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose}"
    const val compose_material3 = "androidx.compose.material3:material3:${Versions.compose_material_3}"
    const val compose_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose}"

    const val coil_compose = "io.coil-kt:coil-compose:${Versions.coil_version}"


    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val compose_ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val compose_ui_test_manifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val compose_ui_tolling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
}
