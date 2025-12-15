@echo off
echo ========================================
echo   Spring Boot JPA Demo Application
echo ========================================
echo.

echo Compilando o projeto...
call mvn clean install

if %ERRORLEVEL% NEQ 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo.
echo Executando a aplicacao...
echo.
echo Configuracoes:
echo   Porta: 8090
echo   Context-path: /api-demo-jpa
echo   URL: http://localhost:8090/api-demo-jpa
echo.
echo Pressione Ctrl+C para parar a aplicacao
echo.

call mvn spring-boot:run

