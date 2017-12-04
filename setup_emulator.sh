#!/bin/bash
sdkmanager "system-images;android-25;google_apis;x86" && echo "no" | avdmanager create avd -n avd_25_x86 -k "system-images;android-25;google_apis;x86"