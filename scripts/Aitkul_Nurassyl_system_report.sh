#!/bin/bash
# System report script - Aitkul Nurassyl, IT2-2307, ID 37375

STUDENT="Aitkul Nurassyl"
LOG_FILE="$HOME/aitkul-nurassyl-student-api/logs/Aitkul_Nurassyl_system_report.log"

{
  echo "========== SYSTEM REPORT =========="
  echo "Student:        $STUDENT"
  echo "Date and time:  $(date '+%Y-%m-%d %H:%M:%S')"
  echo "Username:       $(whoami)"
  echo "OS:             $(. /etc/os-release && echo "$PRETTY_NAME")"
  echo "Kernel:         $(uname -r)"
  echo "--- CPU ---"
  lscpu | grep -E "Architecture|^CPU\(s\)|Model name"
  echo "--- Memory ---"
  free -h
  echo "--- Disk usage ---"
  df -h /
  echo "Available disk space: $(df -h / | awk 'NR==2 {print $4}')"
  echo
} | tee -a "$LOG_FILE"
