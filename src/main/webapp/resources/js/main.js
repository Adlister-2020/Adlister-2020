// MAKE REQUEST
const getAds = () => {
    const url = `/ads`
    return fetch(url)
        .then(response => response.json())
        .then(adsData => {
            console.log(adsData)
            return adsData;
        })
        .catch(error => console.log(error));
}

const getFormModal = ()=> {
    $("#signInModal").modal("toggle");
    $("#registerModal").modal("toggle");
}

// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();


//google callback. This function will redirect to our login servlet
function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId());
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail());
    console.log('id_token: ' + googleUser.getAuthResponse().id_token);

    //do not post all above info to the server because that is not secure.
    //just send the id_token

    var redirectUrl = '/oauth';

    //using jquery to post data dynamically
    var form = $('<form action="' + redirectUrl + '" method="post">' +
        '<input type="text" name="id_token" value="' +
        googleUser.getAuthResponse().id_token + '" />' +
        '</form>');
    $('body').append(form);
    form.submit();
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}






