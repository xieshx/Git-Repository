$(function() {

	$("#member_login").click(function() {
		memberLogin();
	});

});

function memberLogin(){
	// alert("hello");
	$.post(
		"member/selectOne",
		$("#member_form").serialize(),
		function(data){},
		"html",
	);
}