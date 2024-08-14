console.log("Script loaded");

let currentTheme = getTheme();
changeTheme();

function changeTheme() {
    // Apply the current theme
    document.querySelector('html').classList.add(currentTheme);

    const changeThemeButton = document.querySelector('#theme_change_button');

    // Check if the button exists
    if (changeThemeButton) {
        // Update button text based on the current theme
        changeThemeButton.querySelector("span").textContent = currentTheme === "light" ? "Dark" : "Light";

        // Add click event listener to toggle theme
        changeThemeButton.addEventListener("click", () => {
            const oldTheme = currentTheme;
            currentTheme = currentTheme === "dark" ? "light" : "dark";
            setTheme(currentTheme);
            document.querySelector('html').classList.remove(oldTheme);
            document.querySelector('html').classList.add(currentTheme);
            // Update button text after theme change
            changeThemeButton.querySelector("span").textContent = currentTheme === "light" ? "Dark" : "Light";
        });
    } else {
        console.error("Theme change button not found");
    }
}

// Set theme to localStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Get theme from localStorage
function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}
