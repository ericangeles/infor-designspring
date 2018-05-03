start cmd /k call prd\build-backend-instance.bat
start cmd /k call prd\build-frontend-instance.bat
timeout /t 120 /nobreak
start cmd /k call prd\open-prd-monitor.bat