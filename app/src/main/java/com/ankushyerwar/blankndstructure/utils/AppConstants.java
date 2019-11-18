package com.ankushyerwar.blankndstructure.utils;

import android.Manifest;

public class AppConstants {

    //App
    public static final String PACKAGE_NAME = "com.rexaware.uppwd.nigranije";

    //----------------------------------------------------------------------------------------------

    //Base urls
    public static final String BASE_URL = "";
    public static final String BASE_GOOGLE_MAP_URL = "http://maps.google.com/maps?q=loc:";

    //----------------------------------------------------------------------------------------------

    //Retrofit Main Calls
    public static final String API_SERVICE_LOGIN = "Login";

    //----------------------------------------------------------------------------------------------

    //Database
    public static final String DATABASE_NAME = "db-ankusheyrawar";

    //----------------------------------------------------------------------------------------------

    //Shared Pref
    public static final String PREF_NAME = "ANKUSH_Y_PREF";

    //----------------------------------------------------------------------------------------------

    //Required Permissions
    public static final String[] mRequiredPermissions = { Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    //Request Codes
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 200;
    public static final int LOCATION_CAMERA_STORAGE_PERMISSION_REQUEST_CODE = 201;
    public static final int CAMERA_REQUEST_CODE = 202;

    //----------------------------------------------------------------------------------------------

    //Date Formats
    static final String DATE_TIME_PATTERN_1 = "MM/dd/yyyy HH:mm:ss a";
    static final String DATE_TIME_PATTERN_2 = "yyMMddHHmmss";

}
