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





