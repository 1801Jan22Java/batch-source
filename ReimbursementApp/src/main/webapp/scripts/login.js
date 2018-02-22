/**
 * 
 */
function infoConfirm() {
		if (document.reg_fm.id.value.length < 4) {
			alert("Id should be more than 4 letters.");
			reg_fm.id.focus();
			return;
		}
		
		if (document.getElementById("ifManager").checked){
			document.getElementById("lv").value = 0;
		}
		document.reg_fm.submit();
	}