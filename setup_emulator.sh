#!/bin/bash
sdkmanager "system-images;android-24;google_apis;armeabi-v7a" && echo "no" | avdmanager create avd -n avd_24_arm -k "system-images;android-24;google_apis;armeabi-v7a"