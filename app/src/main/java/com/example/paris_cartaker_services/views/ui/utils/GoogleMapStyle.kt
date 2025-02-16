package com.example.paris_cartaker_services.views.ui.utils

import com.example.paris_cartaker_services.views.ui.theme.primary

object GoogleMapStyle {
    const val style: String = """
    [
        {
            "featureType": "all",
            "elementType": "labels.text",
            "stylers": [
            {
                "color": "#878787"
            }
            ]
        },
        {
            "featureType": "all",
            "elementType": "labels.text.stroke",
            "stylers": [
            {
                "visibility": "off"
            }
            ]
        },
        {
            "featureType": "landscape",
            "elementType": "all",
            "stylers": [
            {
                "color": "#f9f5ed"
            }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "all",
            "stylers": [
            {
                "color": "#f5f5f5"
            }
            ]
        },
        {
            "featureType": "road.highway",
            "elementType": "geometry.stroke",
            "stylers": [
            {
                "color": "#c9c9c9"
            }
            ]
        },
        {
            "featureType": "water",
            "elementType": "all",
            "stylers": [
            {
                "color": "#4D5DFA"
            }
            ]
        }
    ]
    """;
}