start cmd /k call dev\build-backend-instance.bat
start cmd /k call dev\build-frontend-instance.bat
timeout /t 120 /nobreak
start cmd /k call dev\open-dev-monitor.bat