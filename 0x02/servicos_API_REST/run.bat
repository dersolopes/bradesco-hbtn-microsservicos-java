@echo off
echo ========================================
echo   Song API - Spring Boot Application
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
echo A API estara disponivel em http://localhost:8080
echo.
echo Endpoints disponiveis:
echo   GET    /api-song/welcome
echo   GET    /api-song/allSongs
echo   GET    /api-song/findSong/{id}
echo   POST   /api-song/addSong
echo   PUT    /api-song/updateSong
echo   DELETE /api-song/removeSong
echo.
echo Pressione Ctrl+C para parar a aplicacao
echo.

call mvn spring-boot:run

