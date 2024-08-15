console.log("Script loaded");

// Initialize currentTheme
let currentTheme = getTheme();

// Apply the current theme and set up the button listener
document.addEventListener("DOMContentLoaded", () => {
    applyTheme(currentTheme);
    setupThemeToggle();
});

function applyTheme(theme) {
    // Set the theme on the page
    document.documentElement.classList.remove("light", "dark");
    document.documentElement.classList.add(theme);

    // Update the theme toggle button text
    const changeThemeButton = document.querySelector("#theme_change_button");
    if (changeThemeButton) {
        const buttonText = theme === "light" ? "Dark" : "Light";
        changeThemeButton.querySelector("span").textContent = buttonText;
    }
}

function setupThemeToggle() {
    const changeThemeButton = document.querySelector("#theme_change_button");
    if (changeThemeButton) {
        changeThemeButton.addEventListener("click", () => {
            const newTheme = currentTheme === "dark" ? "light" : "dark";
            setTheme(newTheme);
            currentTheme = newTheme; // Update the current theme
            applyTheme(newTheme);
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
    const theme = localStorage.getItem("theme");
    return theme ? theme : "light"; // Default to "light" theme
}
