   	$(document).ready(function() {
            $('#loader').hide();
            $("#signup").on("click", function() {
            $("#signup").prop("disabled", true);
                var name = $("#name").val();
                var designation = $("#designation").val();
                //alert(designation);
                var file = $("#file").val(); 
                // Get form
                var form = $('#register-form')[0];
                var data = new FormData(form);
                data.append("name",name);
                data.append("designation",designation);
                //alert(data.get("designation"));
                //alert(data);
                var str = JSON.stringify(data);
                //alert(str);
                //console.log(data);
                $('#loader').show();
                if (name === "" || designation === "" || file === "") {
                	$("#signup").prop("disabled", false);
                    $('#loader').hide();
                    $("#name").css("border-color", "red");
                    $("#designation").css("border-color", "red");
                    $("#file").css("border-color", "red");
                    $("#error_name").html("Please fill the required field.");
                    $("#error_designation").html("Please fill the required field.");
                    $("#error_file").html("Please fill the required field.");
                } else {
                    $("#name").css("border-color", "");
                    $("#designation").css("border-color", "");
                    $("#file").css("border-color", "");
                    $('#error_name').css('opacity', 0);
                    $('#error_designation').css('opacity', 0);
                    $('#error_file').css('opacity', 0);
                    $.ajax({
                        type: 'POST',
                        enctype: 'multipart/form-data',
                        data: data,
                        url: "/image-upload/saveEmployee",
                        processData: false, //prevent jQuery from automatically transforming the data into a query string
                        contentType: false, // tell jQuery not to set contentType
                        cache: false,     
                        success: function(data, statusText, xhr) {
                        console.log(xhr.status);
                        if(xhr.status == "200") {
                        	$('#loader').hide(); 
                            $("#register-form")[0].reset();
                            $("#error").text("");
                            $("#success").text(data);
                            $('#success').delay(5000).fadeOut('slow');
                            $("#signup").prop("disabled", false);
                         }	   
                        },
                        error: function(e){
                        	$('#loader').hide();
                            $("#error").text(e.responseText);
                            $('#error').delay(10000).fadeOut('slow');
                            $("#signup").prop("disabled", false);
                        }
                    });
                }
            });
        });