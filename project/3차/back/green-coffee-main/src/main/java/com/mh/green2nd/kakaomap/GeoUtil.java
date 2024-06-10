package com.mh.green2nd.kakaomap;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;

import java.io.IOException;
import java.net.URLEncoder;

public class GeoUtil {

    public static Float[] findGeoPoint(String address) throws IOException {
        if (address == null) {
            return null;
        }
        address = URLEncoder.encode(address, "UTF-8");
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("ko").getGeocoderRequest();

        Geocoder geocoder = new Geocoder();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

        if (geocoderResponse.getStatus() == GeocoderStatus.OK && !geocoderResponse.getResults().isEmpty()) {
            GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();
            LatLng latLng = geocoderResult.getGeometry().getLocation();

            Float[] coords = new Float[2];
            coords[0] = latLng.getLat().floatValue();
            coords[1] = latLng.getLng().floatValue();
            return coords;
        }
        return null;

    }
}
