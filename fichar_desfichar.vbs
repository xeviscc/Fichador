USER = "DAS USER"
PASS = "PASSWORD"
DELAY_TO_CLOSE = 2500


set objIE = createobject("internetexplorer.application")
objIE.visible = True
objIE.navigate "https://atosspain.bodet-software.com/open/login"
do while objIE.busy
	wscript.sleep 200
loop
'Después de esperar que cargue la página, ponemos loguin y password y hacemos click.
objIE.document.getelementbyid("username").value = USER
objIE.document.getelementbyid("password").value = PASS
objIE.document.getelementbyid("btnAction").click
'Esperamos un momento que cargue la página.
do while objIE.busy
	wscript.sleep 200
loop
'Ejecutamos el JavaScript necesario para fichar.
objIE.document.parentWindow.fcDoAction("BADGER_ES")
'Tiempo de espera para cerrar el navegador.
WScript.Sleep DELAY_TO_CLOSE
'Cerrar el navegador.
objIE.quit()