@ECHO OFF
dir /b /s /a-d src\*.java > sources.txt
javac -d ./build/src/ @sources.txt

Xcopy /e /i /y %cd%\src\com\senla\courses\atm\service\resources %cd%\build\src\com\senla\courses\atm\service\resources

cd build/src
java -cp . com.senla.courses.atm.service.Main
