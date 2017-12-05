#!/bin/bash

# Origin from https://github.com/travis-ci/travis-cookbooks/blob/master/community-cookbooks/android-sdk/files/default/android-wait-for-emulator

set +e

bootanim=""
failcounter=0
timeout_in_sec=360

until [[ "$bootanim" =~ "stopped" ]]; do
  bootanim=`adb -e shell getprop init.svc.bootanim 2>&1 &`
  if [[ "$bootanim" =~ "device not found" || "$bootanim" =~ "device offline"
    || "$bootanim" =~ "running" ]]; then
    let "failcounter += 1"
    echo "Waiting for emulator to start"
    if [[ $failcounter -gt timeout_in_sec ]]; then
      echo "Timeout ($timeout_in_sec seconds) reached; failed to start emulator"
      exit 1
    fi
  fi
  sleep 1
done

echo "Taking ScreenShot"
adb exec-out screencap -p > code/app/build/outputs/apk/screenshot.png

echo "Emulator is ready"