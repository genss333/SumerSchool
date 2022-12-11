const loginvalidate = () => {
    let email = document.forms["loginform"]["email"].value;
    let password = document.forms["loginform"]["password"].value;
    let resultemail = email.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[gmail]+(?:\.[com]+)*$/);
    let passlength = password.length;

    if (email == "") {
        let checkemail = document.getElementById('checkemail');
        let ce = `
			<span style="color:red;font-size:13px;padding-left:5px;">**Email must be filled out</span>
		`
        checkemail.innerHTML = ce;
    } else {
        if (resultemail == null) {
            let checkemail = document.getElementById('checkemail');
            let ce = `
				<span style="color:red;font-size:13px;padding-left:5px;">**Plase enter email address</span>
			`
            checkemail.innerHTML = ce;

        } else {

            let checkemail = document.getElementById('checkemail');
            let ce = `
				<span></span>
			`
            checkemail.innerHTML = ce;
        }
    }

    var strength = 0;

    if (password.match(/[a-z]+/)) {
        strength += 1;
    }
    if (password.match(/[A-Z]+/)) {
        strength += 1;
    }
    if (password.match(/[0-9]+/)) {
        strength += 1;
    }
    if (password.match(/[.!#$%&'*+/=?^_]+/)) {
        strength += 1;

    }

    if (password.length <= 8) {
        let checkpass = document.getElementById('checkpass');
        let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**minimum number of characters is 8</span>
		`
        checkpass.innerHTML = cp;
    } else if (password.length >= 20) {
        let checkpass = document.getElementById('checkpass');
        let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**maximum number of characters is 20</span>
		`
        checkpass.innerHTML = cp;
    } else {

        if (strength < 4) {
            let checkpass = document.getElementById('checkpass');
            let cp = `
				<span style="color:red;font-size:13px;padding-left:5px;">**password don't have a-z, A-Z, 0-9 and special characters</span>
			`
            checkpass.innerHTML = cp;
        } else {
            let checkpass = document.getElementById('checkpass');
            let cp = `
			<span></span>
		`
            checkpass.innerHTML = cp;
        }

    }


    if (email == "" || password == "" || resultemail == null || passlength < 8 || passlength > 20 || strength < 4) {
        return false
    } else {
        return true
    }
}

const RegisterValidate = () => {

    let fname = document.forms["registerform"]["fname"].value;
    let lname = document.forms["registerform"]["lname"].value;
    let email = document.forms["registerform"]["email"].value;
    let password = document.forms["registerform"]["password"].value;
    let repeat = document.forms["registerform"]["repeatpass"].value;

    var letters = /^[a-zA-Z]+$/;

    if (fname == "") {
        let checkfname = document.getElementById('checkfname');
        let cf = `
			<span style="color:red;font-size:13px;">**FirstName must be filled out</span>
		`
        checkfname.innerHTML = cf;
    } else {
        if (fname.match(letters) != null) {
            let checkfname = document.getElementById('checkfname');
            let cf = `
				<p></p>
			`
            checkfname.innerHTML = cf;
        } else {
            let checkfname = document.getElementById('checkfname');
            let cf = `
			<p style="color:red;font-size:13px;">**plase input only charactor</p>
		`
            checkfname.innerHTML = cf;
        }
    }

    if (lname == "") {
        let checklname = document.getElementById('checklname');
        let cl = `
			<span style="color:red;font-size:13px;">**LastName must be filled out</span>
		`
        checklname.innerHTML = cl;
    } else {
        if (lname.match(letters) != null) {
            let checklname = document.getElementById('checklname');
            let cl = `
				<span></span>
			`
            checklname.innerHTML = cl;
        } else {
            let checklname = document.getElementById('checklname');
            let cl = `
			<span style="color:red;font-size:13px;">**plase input only charactor</span>
		`
            checklname.innerHTML = cl;
        }
    }

    let resultemail = email.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[gmail]+(?:\.[com]+)*$/);

    if (email == "") {
        let checkemail = document.getElementById('checkemail');
        let ce = `
			<span style="color:red;font-size:13px;padding-left:5px;">**Email must be filled out</span>
		`
        checkemail.innerHTML = ce;
    } else {
        if (resultemail == null) {
            let checkemail = document.getElementById('checkemail');
            let ce = `
				<span style="color:red;font-size:13px;padding-left:5px;">**Plase enter email address</span>
			`
            checkemail.innerHTML = ce;

        } else {

            let checkemail = document.getElementById('checkemail');
            let ce = `
				<span></span>
			`
            checkemail.innerHTML = ce;
        }
    }

    var strength = 0;

    if (password.match(/[a-z]+/)) {
        strength += 1;
    }
    if (password.match(/[A-Z]+/)) {
        strength += 1;
    }
    if (password.match(/[0-9]+/)) {
        strength += 1;
    }
    if (password.match(/[.!#$%&'*+/=?^_]+/)) {
        strength += 1;

    }

    if (password.length <= 8) {
        let checkpass = document.getElementById('checkpass');
        let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**minimum number of characters is 8</span>
		`
        checkpass.innerHTML = cp;
    } else if (password.length >= 12) {
        let checkpass = document.getElementById('checkpass');
        let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**maximum number of characters is 20</span>
		`
        checkpass.innerHTML = cp;
    } else {

        if (strength < 4) {
            let checkpass = document.getElementById('checkpass');
            let cp = `
				<span style="color:red;font-size:13px;padding-left:5px;">**password don't have a-z, A-Z, 0-9 and special characters</span>
			`
            checkpass.innerHTML = cp;
        } else {
            let checkpass = document.getElementById('checkpass');
            let cp = `
			<span></span>
		`
            checkpass.innerHTML = cp;
        }

    }

    if (repeat == "") {
        let checkpass = document.getElementById('checkpass2');
        let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**Repeat password must be filled out</span>
		`
        checkpass.innerHTML = cp;
    } else {
        if (password != repeat) {
            let checkpass = document.getElementById('checkpass2');
            let cp = `
			<span style="color:red;font-size:13px;padding-left:5px;">**Repeat password be not equals password</span>
		`
            checkpass.innerHTML = cp;
        } else {
            let checkpass = document.getElementById('checkpass2');
            let cp = `
			<span></span>
		`
            checkpass.innerHTML = cp;
        }
    }

    if (fname == "" || fname.match(letters) == null || lname == "" || lname.match(letters) == null || email == "" || resultemail == null || password.length < 8 ||
        password.length > 20 || strength < 4 || repeat == "" || password != repeat) {
        return false;
    } else {
        return true;
    }

}



/**
 *
 */