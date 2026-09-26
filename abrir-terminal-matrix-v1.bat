@echo off
title [.:.]_ Terminal Windows _[.:.]
color 8F
cd /d "%~dp0"

echo =========================================================================
echo  -- PALETA DE COLORES ANSI (Copiar el comando) --
echo =========================================================================
echo  Azul: prompt $e[4;5;31m[*]$e[0m $e[36m$p$g$e[0m
echo  Verde 1: prompt $e[4;5;31m[*]$e[0m $e[1;92m$p$g$e[0m
echo  Verde 2: prompt $e[4;5;31m[*]$e[0m $e[4;32m$p$g$e[0m
echo  Amarillo: prompt $e[4;5;31m[*]$e[0m $e[93m$p$g$e[0m
echo  Naranja:  prompt $e[4;5;31m[*]$e[0m $e[33m$p$g$e[0m
echo  Celeste:  prompt $e[4;5;31m[*]$e[0m $e[96m$p$g$e[0m
echo =========================================================================
echo.

REM Validamos si existe Windows Terminal en el sistema
where wt >nul 2>nul
if %errorlevel% equ 0 (
    echo [OK] Abriendo perfiles en Windows Terminal...
    wt -w 0 -p "Docker" -d . ^; new-tab -p "BACK: Spring Boot" -d .
) else (
    echo [Plan B] Windows Terminal no detectado. Abriendo consolas clasicas...
    start ".:.docker.:." cmd /k color 0b
    start ".:. java .:." cmd /k color 0a
)

echo.
echo Presiona una tecla para cerrar esta ventana guia.
pause >nul
exit