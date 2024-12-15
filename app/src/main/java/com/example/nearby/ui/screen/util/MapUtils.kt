package com.example.nearby.ui.screen.util

import com.google.android.gms.maps.model.LatLng

fun findSoutheastestPont(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var southestestPoint = points[0]

    for (point in points) {
        if (point.latitude < southestestPoint.latitude || point.latitude == southestestPoint.latitude && point.longitude < southestestPoint.longitude) {
            southestestPoint = point
        }
    }

    return southestestPoint
}

fun findNortheastestPont(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var northeastestPoint = points[0]

    for (point in points) {
        if (point.latitude > northeastestPoint.latitude || point.latitude == northeastestPoint.latitude && point.longitude > northeastestPoint.longitude) {
            northeastestPoint = point
        }
    }

    return northeastestPoint
}