console.log("Contacts.js");
const baseURL = "http://localhost:8081";
const viewContactModal = document.getElementById("view_contact_modal");

// options with default values
const options = {
    placement: "bottom-right",
    backdrop: "dynamic",
    backdropClasses: "bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40",
    closable: true,
    onHide: () => {
        console.log("modal is hidden");
    },
    onShow: () => {
        setTimeout(() => {
            viewContactModal.classList.add("scale-100");
        }, 50);
    },
    onToggle: () => {
        console.log("modal has been toggled");
    },
};

// instance options object
const instanceOptions = {
    id: "view_contact_mdoal",
    override: true,
};

const contactModal = new Modal(viewContactModal, options, instanceOptions);

function openContactModal() {
    contactModal.show();
}

function closeContactModal() {
    contactModal.hide();
}

async function loadContactdata(id) {
    //function call to load data
    console.log(id);
    try {
        const data = await (await fetch(`${baseURL}/api/contacts/${id}`)).json();
        console.log(data);
        document.querySelector("#contact_name").innerHTML = data.name;
        document.querySelector("#contact_email").innerHTML = data.email;
        document.querySelector("#contact_image").src = data.picture || "https://static-00.iconduck.com/assets.00/profile-default-icon-2048x2045-u3j7s5nj.png";
        document.querySelector("#contact_address").innerHTML = data.address;
        document.querySelector("#contact_phone").innerHTML = data.phoneNumber;
        document.querySelector("#contact_about").innerHTML = data.description;
        const contactFavorite = document.querySelector("#contact_favorite");
        if (data.favorite) {
            contactFavorite.innerHTML =
                "<i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i><i class='fas fa-star text-yellow-400'></i>";
        } else {
            contactFavorite.innerHTML = "Not Favorite Contact";
        }

        document.querySelector("#contact_website").href = data.websiteLink;
        document.querySelector("#contact_website").innerHTML = data.websiteLink;
        document.querySelector("#contact_linkedIn").href = data.linkedInLink;
        document.querySelector("#contact_linkedIn").innerHTML = data.linkedInLink;
        openContactModal();
    } catch (error) {
        console.log("Error: ", error);
    }
}


//delete with sweet alert
// async function deleteContact(id) {
//     const isDarkMode = document.documentElement.classList.contains('dark'); // Detect dark mode

//     const result = await Swal.fire({
//         title: 'Do you want to delete the contact?',
//         showCancelButton: true,
//         confirmButtonText: 'Delete',
//         cancelButtonText: 'Cancel',
//         confirmButtonColor: isDarkMode ? '#dc2626' : '#ef4444', // Red color for both dark and light modes
//         cancelButtonColor: isDarkMode ? '#6b7280' : '#1f2937', // Dark mode: Gray-600, Light mode: Gray-300
//         background: isDarkMode ? '#1f2937' : '#fff', // Dark mode: Gray-800, Light mode: White
//         color: isDarkMode ? '#f9fafb' : '#000', // Dark mode: Gray-50, Light mode: Black
//         customClass: {
//             confirmButton: `text-white ${isDarkMode ? 'bg-red-600 hover:bg-red-700 focus:ring-red-300' : 'bg-red-600 hover:bg-red-700 focus:ring-red-500'} font-medium rounded-lg text-sm px-6 py-2`,
//             cancelButton: `text-white ${isDarkMode ? 'bg-gray-600 hover:bg-gray-700 focus:ring-gray-300' : 'bg-gray-300 hover:bg-gray-400 focus:ring-gray-500'} font-medium rounded-lg text-sm px-6 py-2`,
//             title: 'text-lg font-semibold',
//             content: 'text-base'
//         }
//     });

//     if (result.isConfirmed) {
//         // Redirect to the URL after confirmation
//         const url = `${baseURL}/user/contacts/delete/${id}`;


//         // Show success message
//         Swal.fire({
//             title: 'Deleted!',
//             text: 'The contact has been deleted.',
//             icon: 'success',
//             background: isDarkMode ? '#1f2937' : '#fff',
//             color: isDarkMode ? '#f9fafb' : '#000',
//             customClass: {
//                 confirmButton: `text-white ${isDarkMode ? 'bg-red-600 hover:bg-red-700 focus:ring-red-300' : 'bg-red-600 hover:bg-red-700 focus:ring-red-500'} font-medium rounded-lg text-sm px-6 py-2`,
//                 title: 'text-lg font-semibold',
//                 content: 'text-base'
//             }
//         });

//         window.location.replace(url);
//     }

//     /*
//     if need to customize view after cancel
//     else if (result.isDismissed) {
//         Swal.fire({
//             title: 'Cancelled',
//             text: 'The contact was not deleted.',
//             icon: 'info',
//             background: isDarkMode ? '#1f2937' : '#fff',
//             color: isDarkMode ? '#f9fafb' : '#000',
//             customClass: {
//                 confirmButton: `text-white ${isDarkMode ? 'bg-gray-600 hover:bg-gray-700 focus:ring-gray-300' : 'bg-gray-800 hover:bg-gray-900 focus:ring-gray-500'} font-medium rounded-lg text-sm px-6 py-2`,
//                 title: 'text-lg font-semibold',
//                 content: 'text-base'
//             }
//         });
//     }
//     */

// }

async function deleteContact(id) {
    const isDarkMode = document.documentElement.classList.contains('dark'); // Detect dark mode

    const result = await Swal.fire({
        title: 'Do you want to delete the contact?',
        showCancelButton: true,
        confirmButtonText: 'Delete',
        cancelButtonText: 'Cancel',
        confirmButtonColor: isDarkMode ? '#dc2626' : '#ef4444', // Red color for both dark and light modes
        cancelButtonColor: isDarkMode ? '#6b7280' : '#1f2937', // Dark mode: Gray-600, Light mode: Gray-300
        background: isDarkMode ? '#1f2937' : '#fff', // Dark mode: Gray-800, Light mode: White
        color: isDarkMode ? '#f9fafb' : '#000', // Dark mode: Gray-50, Light mode: Black
        customClass: {
            confirmButton: `text-white ${isDarkMode ? 'bg-red-600 hover:bg-red-700 focus:ring-red-300' : 'bg-red-600 hover:bg-red-700 focus:ring-red-500'} font-medium rounded-lg text-sm px-6 py-2`,
            cancelButton: `text-white ${isDarkMode ? 'bg-gray-600 hover:bg-gray-700 focus:ring-gray-300' : 'bg-gray-300 hover:bg-gray-400 focus:ring-gray-500'} font-medium rounded-lg text-sm px-6 py-2`,
            title: 'text-lg font-semibold',
            content: 'text-base'
        }
    });

    if (result.isConfirmed) {
        const url = `${baseURL}/user/contacts/delete/${id}`;

        // Perform AJAX request
        const response = await fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            // Show success message
            await Swal.fire({
                title: 'Deleted!',
                text: 'The contact has been deleted.',
                icon: 'success',
                background: isDarkMode ? '#1f2937' : '#fff',
                color: isDarkMode ? '#f9fafb' : '#000',
                customClass: {
                    confirmButton: `text-white ${isDarkMode ? 'bg-red-600 hover:bg-red-700 focus:ring-red-300' : 'bg-red-600 hover:bg-red-700 focus:ring-red-500'} font-medium rounded-lg text-sm px-6 py-2`,
                    title: 'text-lg font-semibold',
                    content: 'text-base'
                }
            });

            window.location.replace(`${baseURL}/user/contacts`);

        } else {
            // Handle failure response
            await Swal.fire({
                title: 'Error!',
                text: 'Failed to delete the contact.',
                icon: 'error',
                background: isDarkMode ? '#1f2937' : '#fff',
                color: isDarkMode ? '#f9fafb' : '#000',
                customClass: {
                    confirmButton: `text-white ${isDarkMode ? 'bg-red-600 hover:bg-red-700 focus:ring-red-300' : 'bg-red-600 hover:bg-red-700 focus:ring-red-500'} font-medium rounded-lg text-sm px-6 py-2`,
                    title: 'text-lg font-semibold',
                    content: 'text-base'
                }
            });
        }
    }
}

