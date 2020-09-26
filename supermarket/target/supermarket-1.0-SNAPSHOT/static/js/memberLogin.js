$(function() {

	$("#member_login").click(function() {
		memberLogin();
	});

});

function memberLogin(){
	$.post(
		"member/selectOne",
		$("#member_form").serialize(),
		function(data){},
		"html",
	);
}