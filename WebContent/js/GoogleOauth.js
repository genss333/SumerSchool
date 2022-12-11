
function onSignIn(googleUser) {

	var profile = googleUser.getBasicProfile();
	console.log('ID: ' + profile.getId());
	console.log('Name: ' + profile.getName());
	console.log('Image URL: ' + profile.getImageUrl());
	console.log('Email: ' + profile.getEmail());
	console.log('id_token: ' + googleUser.getAuthResponse().id_token);
	var btnlogin = document.getElementById("login-google");

	var redirectUrl = 'GoogleAouthServlet';
	//using jquery to post data dynamically
	var form = $('<form action="' + redirectUrl + '" method="post">'
		+ '<input type="text" name="id_token" value="'
		+ googleUser.getAuthResponse().id_token + '" />' + '</form>');
	
	btnlogin.onclick = function(){
		$('body').append(form);
		form.submit();
	}
	
}
