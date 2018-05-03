start cmd /k call qa\build-backend-instance.bat
start cmd /k call qa\build-frontend-instance.bat
timeout /t 120 /nobreak
start cmd /k call qa\open-qa-monitor.bat