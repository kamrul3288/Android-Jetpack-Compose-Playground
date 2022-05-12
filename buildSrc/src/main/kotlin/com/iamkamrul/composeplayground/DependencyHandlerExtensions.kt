package com.iamkamrul.composeplayground

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAndroidxDependencies() {
    androidxDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addLifeCycleDependencies() {
    lifeCycleDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addComposeDependencies() {
    composeDependencies.forEach {
        add("implementation",it)
    }
}



fun DependencyHandler.addAndroidTestsDependencies() {
    androidTestsDependencies.forEachIndexed { index, dep ->
        when(index){
            0->add("testImplementation",dep)
            1,2,3->add("androidTestImplementation",dep)
            else->add("debugImplementation",dep)
        }
    }
}


