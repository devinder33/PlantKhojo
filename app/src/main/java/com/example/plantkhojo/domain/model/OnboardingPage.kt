package com.example.plantkhojo.domain.model

import com.example.plantkhojo.R

data class OnboardingPage(
    val title: String,
    val image: Int
)

fun getList(): List<OnboardingPage> {
    return listOf(
        OnboardingPage(
            "Scan to identify a plant",
            R.drawable.onboarding_image_one,
        ),
        OnboardingPage(
            "Get Plant Information",
            R.drawable.onboarding_image_one,
        ),
        OnboardingPage(
            "Save Details for future use",
            R.drawable.onboarding_image_three,
        ),
    )
}

