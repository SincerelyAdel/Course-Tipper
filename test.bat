@echo off

REM Define an array of strings
set "strings=24920 29402 49033 49203 49304"

REM Sleep for 2 seconds
timeout /t 1 > nul

REM Run PowerShell code
echo $wshell = New-Object -ComObject WScript.Shell > temp.ps1
echo foreach ($str in "%strings%".Split(' ')) { $wshell.SendKeys("$str`t") } >> temp.ps1
echo for ($i = 1; $i -le 3; $i++) { $wshell.SendKeys("`t") } >> temp.ps1
echo $wshell.SendKeys("{ENTER}") >> temp.ps1
powershell -ExecutionPolicy Bypass -File temp.ps1

REM Delete temporary PowerShell script
del temp.ps1

exit