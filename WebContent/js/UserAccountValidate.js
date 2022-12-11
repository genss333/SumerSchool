7
const UserValidate = () => {

    let fname = document.forms["account"]["fname"].value;
    let lname = document.forms["account"]["lname"].value;
    let email = document.forms["account"]["email"].value;
    let phone = document.forms["account"]["phone"].value;
    let street = document.forms["account"]["street"].value;
    let city = document.forms["account"]["city"].value;
    let state = document.forms["account"]["state"].value;
    let zipcode = document.forms["account"]["zipcode"].value;

    var letters = /^[a-zA-Z]+$/;
    var number = /^[0-9]+$/;

    if (fname == "") {
        let checkfname = document.getElementById('fname');
        let cf = `
			<span style="color:red;font-size:13px;padding-left:5px;">**Firstname must be filled out</span>
		`
        checkfname.innerHTML = cf;
    } else {
        if (fname.match(letters) == null) {
            let checkfname = document.getElementById('fname');
            let cf = `
				<span style="color:red;font-size:13px;padding-left:5px;">**Plase enter only charactor</span>
			`
            checkfname.innerHTML = cf;

        } else {

            let checkfname = document.getElementById('fname');
            let cf = `
				<span></span>
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

    if (phone == "") {
        let ckphone = document.getElementById('checkphone');
        let cp = `
        <span style="color:red;font-size:13px;padding-left:5px;">**Phone must be filled out</span>
        `
        ckphone.innerHTML = cp;
    } else {
        if (phone.length != 10) {
            let ckphone = document.getElementById('checkphone');
            let cp = `
                    <span style="color:red;font-size:13px;padding-left:5px;">**Phone must be 10 digist</span>
                `
            ckphone.innerHTML = cp;
        } else {
            if (phone.match(number) == null) {
                let ckphone = document.getElementById('checkphone');
                let cp = `
                    <span style="color:red;font-size:13px;padding-left:5px;">**Please enter only number</span>
                `
                ckphone.innerHTML = cp;
            } else {
                let ckphone = document.getElementById('checkphone');
                let cp = `
                    <span></span>
                `
                ckphone.innerHTML = cp;
            }
            let ckphone = document.getElementById('checkphone');
            let cp = `
                    <span></span>
                `
            ckphone.innerHTML = cp;
        }

    }

    if (street == "") {
        let ckstreet = document.getElementById('checkstreet');
        let cs = `
            <span style="color:red;font-size:13px;padding-left:5px;">**Street must be filled out</span>
        `
        ckstreet.innerHTML = cs;
    } else {
        if (street.match(number) == null) {
            let ckstreet = document.getElementById('checkstreet');
            let cs = `
                <span style="color:red;font-size:13px;padding-left:5px;">**Please enter only number</span>
             `
            ckstreet.innerHTML = cs;
        } else {
            let ckstreet = document.getElementById('checkstreet');
            let cs = `
                <span></span>
             `
            ckstreet.innerHTML = cs;
        }
    }

    if (city == "") {
        let ckcity = document.getElementById('checkcity');
        let cc = `
            <span style="color:red;font-size:13px;padding-left:5px;">**City must be filled out</span>
        `
        ckcity.innerHTML = cc;
    } else {
        if (city.match(letters) == null) {
            let ckcity = document.getElementById('checkcity');
            let cc = `
            <span style="color:red;font-size:13px;padding-left:5px;">**plase input only charactor</span>
        `
            ckcity.innerHTML = cc;
        } else {
            let ckcity = document.getElementById('checkcity');
            let cc = `
            <span></span>
        `
            ckcity.innerHTML = cc;
        }
    }

    if (state == "") {
        let ckstate = document.getElementById('checkstate');
        let cc = `
            <span style="color:red;font-size:13px;padding-left:5px;">**State must be filled out</span>
        `
        ckstate.innerHTML = cc;
    } else {
        if (state.match(letters) == null) {
            let ckstate = document.getElementById('checkstate');
            let cc = `
            <span style="color:red;font-size:13px;padding-left:5px;">**plase input only charactor</span>
        `
            ckstate.innerHTML = cc;
        } else {
            let ckstate = document.getElementById('checkstate');
            let cc = `
            <span></span>
        `
            ckstate.innerHTML = cc;
        }
    }

    if (zipcode == "") {
        let ckzipcode = document.getElementById('checkzipcode');
        let cp = `
        <span style="color:red;font-size:13px;padding-left:5px;">**Zipcode must be filled out</span>
        `
        ckzipcode.innerHTML = cp;
    } else {
        if (zipcode.length != 5) {
            let ckzipcode = document.getElementById('checkzipcode');
            let cp = `
                    <span style="color:red;font-size:13px;padding-left:5px;">**Zipcode must be 5 digist</span>
                `
            ckzipcode.innerHTML = cp;
        } else {
            if (zipcode.match(number) == null) {
                let ckzipcode = document.getElementById('checkzipcode');
                let cp = `
                    <span style="color:red;font-size:13px;padding-left:5px;">**Please enter only number</span>
                `
                ckzipcode.innerHTML = cp;
            } else {
                let ckzipcode = document.getElementById('checkzipcode');
                let cp = `
                    <span></span>
                `
                ckzipcode.innerHTML = cp;
            }
            let ckzipcode = document.getElementById('checkzipcode');
            let cp = `
                    <span></span>
                `
            ckzipcode.innerHTML = cp;
        }

    }


    if (fname == "" || fname.match(letters) == null || lname == "" || lname.match(letters) == null ||
        email == "" || resultemail == null || phone.match(number) == null || phone == "" || phone.length != 10 ||
        street == "" || street.match(number) == null || city == "" || city.match(letters) == null ||
        state == "" || state.match(letters) == null || zipcode == "" || zipcode.match(number) == null || zipcode.length != 5) {

        return false;

    } else {

        return true;
    }

}