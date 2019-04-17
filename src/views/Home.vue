<template>
  <div class="home">
    <div class="container">
      <div class="header">
        <img
          class="sun"
          src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDUxMiA1MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMiA1MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIiB3aWR0aD0iNTEycHgiIGhlaWdodD0iNTEycHgiPgo8cGF0aCBzdHlsZT0iZmlsbDojRkZBNjAwOyIgZD0iTTUwNy44MzQsMzAxLjYwOGwtNTQuNzY5LTQ4LjMxMmw1Mi44MzItNTAuMzk5YzEuOTQxLTEuODUyLDIuNzQtNC41OTEsMi4wOTktNy4xODkgIGMtMC42NDItMi41OTctMi42MjktNC42NTUtNS4yMTEtNS40MDFsLTcwLjMxNi0yMC4yOTJsMjUuOTg4LTY4LjA1NmMwLjk1NS0yLjUsMC40OTUtNS4zMTYtMS4yMDQtNy4zODkgIGMtMS43LTIuMDcyLTQuMzgzLTMuMDg1LTcuMDM4LTIuNjU3bC03Mi4yNzQsMTEuNjUybC01Ljg3OC03Mi41NjFjLTAuMjE2LTIuNjY2LTEuODQ2LTUuMDE1LTQuMjc1LTYuMTYxICBjLTIuNDI5LTEuMTQ2LTUuMjkxLTAuOTE3LTcuNTA0LDAuNjAxbC02MC4yNjYsNDEuMzQyTDI2My40MDksMy43NDJDMjYyLjA2NCwxLjQyNiwyNTkuNTc5LDAsMjU2Ljg4OSwwICBjLTIuNjksMC01LjE3NCwxLjQyNi02LjUxOSwzLjc0MkwyMDguMzQ3LDc2LjExbC03Mi42OS00MS45NTNjLTIuMzI3LTEuMzQzLTUuMTk3LTEuMzQ5LTcuNTI4LTAuMDE4ICBjLTIuMzMzLDEuMzMxLTMuNzczLDMuNzk5LTMuNzgsNi40NzNsLTAuMTc2LDcyLjc5NWwtNzIuOTY1LTYuMDE0Yy0yLjY3NS0wLjIyLTUuMjc1LDAuOTk3LTYuODA3LDMuMTk0ICBjLTEuNTMzLDIuMTk3LTEuNzcxLDUuMDQxLTAuNjIyLDcuNDU5bDMxLjI0Miw2NS44MzVMNi41MDgsMjA5LjU2MmMtMi41MTYsMC45NDMtNC4zMzUsMy4xNS00Ljc3Myw1Ljc4OSAgYy0wLjQzOCwyLjYzOCwwLjU3NSw1LjMwOCwyLjY1Niw3LjAwM2w1Ni42MTksNDYuMTUybC01MC44MTMsNTIuNDFjLTEuODY2LDEuOTI1LTIuNTU5LDQuNjk0LTEuODE2LDcuMjY0ICBjMC43NDQsMi41NywyLjgxLDQuNTUsNS40MTksNS4xOTRsNzEuMDU1LDE3LjU1MUw2MS41Niw0MTkuOTM2Yy0wLjg1NiwyLjUzNS0wLjI4Niw1LjMzMSwxLjQ5NCw3LjMzNiAgYzEuNzgxLDIuMDA1LDQuNTAyLDIuOTEzLDcuMTM3LDIuMzgybDcxLjc2LTE0LjQ0M2w4LjcyMSw3Mi4yNzhjMC4zMTksMi42NTUsMi4wNDEsNC45MzgsNC41MTMsNS45OSAgYzIuNDc0LDEuMDUyLDUuMzIzLDAuNzEyLDcuNDc1LTAuODkxbDU4LjU5Ni00My42NDdsMzkuMDU1LDU5LjU2NmMxLjM4MiwyLjE3OSwzLjc4OSwzLjQ5Miw2LjM2NywzLjQ5MiAgYzAuMDk4LDAsMC4xOTYtMC4wMDIsMC4yOTUtMC4wMDZjMi42ODctMC4xMDQsNS4xMTUtMS42MjYsNi4zNjgtMy45OTJsMzQuMTA3LTYyLjQwNWw2MS44MzksMzguOTc0ICBjMi4yNzMsMS40MzIsNS4xMzcsMS41NSw3LjUyMiwwLjMxYzIuMzgyLTEuMjQsMy45MTktMy42NSw0LjAzLTYuMzIybDMuMDMxLTcyLjczNGw3Mi42NzQsOC44NGMyLjY2NCwwLjMyNCw1LjMxLTAuNzkxLDYuOTI4LTIuOTI3ICBjMS42MTgtMi4xMzcsMS45NjYtNC45NjksMC45MTQtNy40M2wtMjguNjM2LTY2Ljk5N2w2OS40NjUtMjMuMDAzYzIuNTUyLTAuODQ1LDQuNDU2LTIuOTc5LDQuOTk3LTUuNTk5ICBDNTEwLjc1MiwzMDYuMDksNTA5Ljg0NSwzMDMuMzgzLDUwNy44MzQsMzAxLjYwOHoiLz4KPGVsbGlwc2Ugc3R5bGU9ImZpbGw6I0ZGREIyRDsiIGN4PSIyNTQuMzUiIGN5PSIyNTQuNjkxIiByeD0iMTU1LjA2OSIgcnk9IjE1NC45NDkiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0ZGQ0EwMDsiIGQ9Ik0yNTQuMzU0LDk5Ljc0M2MtMy44ODQsMC03LjczMiwwLjE0Ny0xMS41NDMsMC40MjhjODAuMjUsNS45MDEsMTQzLjUyNSw3Mi44MjUsMTQzLjUyNSwxNTQuNTIxICBjMCw4MS42OTUtNjMuMjc1LDE0OC42MTktMTQzLjUyNSwxNTQuNTIxYzMuODExLDAuMjgsNy42NiwwLjQyOCwxMS41NDMsMC40MjhjODUuNjQxLDAsMTU1LjA2OC02OS4zNzMsMTU1LjA2OC0xNTQuOTQ4ICBDNDA5LjQyMiwxNjkuMTE2LDMzOS45OTUsOTkuNzQzLDI1NC4zNTQsOTkuNzQzeiIvPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K"
        >
        <img
          class="moon hide"
          src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDQ5OS43MTIgNDk5LjcxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDk5LjcxMiA0OTkuNzEyOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjUxMnB4IiBoZWlnaHQ9IjUxMnB4Ij4KPHBhdGggc3R5bGU9ImZpbGw6I0ZGRDkzQjsiIGQ9Ik0xNDYuODgsMzc1LjUyOGMxMjYuMjcyLDAsMjI4LjYyNC0xMDIuMzY4LDIyOC42MjQtMjI4LjY0YzAtNTUuOTUyLTIwLjE2LTEwNy4xMzYtNTMuNTItMTQ2Ljg4ICBDNDI1LjA1NiwzMy4wOTYsNDk5LjY5NiwxMjkuNjQsNDk5LjY5NiwyNDMuNzA0YzAsMTQxLjM5Mi0xMTQuNjA4LDI1Ni0yNTYsMjU2Yy0xMTQuMDY0LDAtMjEwLjYwOC03NC42NC0yNDMuNjk2LTE3Ny43MTIgIEMzOS43NDQsMzU1LjM2OCw5MC45NDQsMzc1LjUyOCwxNDYuODgsMzc1LjUyOHoiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0Y0QzUzNDsiIGQ9Ik00MDEuOTIsNDIuNzc2YzM0LjI0LDQzLjUwNCw1NC44MTYsOTguMjcyLDU0LjgxNiwxNTcuOTUyYzAsMTQxLjM5Mi0xMTQuNjA4LDI1Ni0yNTYsMjU2ICBjLTU5LjY4LDAtMTE0LjQ0OC0yMC41NzYtMTU3Ljk1Mi01NC44MTZjNDYuODQ4LDU5LjQ3MiwxMTkuMzQ0LDk3Ljc5MiwyMDAuOTI4LDk3Ljc5MmMxNDEuMzkyLDAsMjU2LTExNC42MDgsMjU2LTI1NiAgQzQ5OS43MTIsMTYyLjEyLDQ2MS4zOTIsODkuNjQsNDAxLjkyLDQyLjc3NnoiLz4KPGc+Cgk8cG9seWdvbiBzdHlsZT0iZmlsbDojRkZEODNCOyIgcG9pbnRzPSIxMjguMTI4LDk5Ljk0NCAxNTQuNDk2LDE1My40IDIxMy40NzIsMTYxLjk2IDE3MC44LDIwMy41NiAxODAuODY0LDI2Mi4yOTYgICAgMTI4LjEyOCwyMzQuNTY4IDc1LjM3NiwyNjIuMjk2IDg1LjQ0LDIwMy41NiA0Mi43NjgsMTYxLjk2IDEwMS43NDQsMTUzLjQgICIvPgoJPHBvbHlnb24gc3R5bGU9ImZpbGw6I0ZGRDgzQjsiIHBvaW50cz0iMjc2Ljg2NCw4Mi44NCAyOTAuNTI4LDExMC41NTIgMzIxLjEwNCwxMTQuOTg0IDI5OC45NzYsMTM2LjU1MiAzMDQuMjA4LDE2Ni45ODQgICAgMjc2Ljg2NCwxNTIuNjE2IDI0OS41MiwxNjYuOTg0IDI1NC43NTIsMTM2LjU1MiAyMzIuNjI0LDExNC45ODQgMjYzLjIsMTEwLjU1MiAgIi8+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg=="
        >
      </div>
      <div class="content">
        <h1>Hello</h1>
        <!-- <p>Click the sun/moon</p> -->
      </div>
    </div>
  </div>
</template>
<script>
export default {
  mounted() {
    this.init();
  },
  methods: {
    init() {
      const lightMode = document.querySelector(".sun");
      const darkMode = document.querySelector(".moon");

      const currentTheme = localStorage.getItem("theme")
        ? localStorage.getItem("theme")
        : null;

      lightMode.onclick = function() {
        document.documentElement.setAttribute("data-theme", "dark");
        lightMode.style = "display: none";
        darkMode.style = "display: block";
        localStorage.setItem("theme", "dark");
      };

      darkMode.onclick = function() {
        document.documentElement.setAttribute("data-theme", "light");
        lightMode.style = "display: block";
        darkMode.style = "display: none";
        localStorage.setItem("theme", "light");
      };

      if (currentTheme) {
        document.documentElement.setAttribute("data-theme", currentTheme);

        if (currentTheme === "dark") {
          lightMode.style = "display: none";
          darkMode.style = "display: block";
        }
      } else {
        const currentHours = new Date().getHours();
        if (currentHours >= 19 || currentHours <= 7) {
          document.documentElement.setAttribute("data-theme", "dark");
          lightMode.style = "display: none";
          darkMode.style = "display: block";
        }
      }
    }
  }
};
</script>

<style lang="scss">
:root {
  --primary-color: #1b1e24;
  --secondary-color: #1b1e24;
  --font-color: #1b1e24;
  --bg-color: #fff;
  --heading-color: #1b1e24;
}

[data-theme="dark"] {
  --primary-color: #fff;
  --secondary-color: #fff;
  --font-color: #fff;
  --bg-color: #1b1e24;
  --heading-color: #fff;
}

.home {
  background-color: var(--bg-color);
  height: 100%;
}

.container {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  height: 80vh;
  .content h1 {
    color: var(--primary-color);
    font-family: "Dosis", sans-serif;
    font-size: 5rem;
  }
  .content p {
    color: var(--primary-color);
    font-family: "Dosis", sans-serif;
    font-size: 2rem;
  }
}

.header {
  position: absolute;
  top: 10px;
  right: 20px;
  .moon,
  .sun {
    width: 34px;
    cursor: pointer;
    transition: 0.5s all ease-in-out;
  }
  .sun:hover {
    animation: sun_rotate 1s infinite;
  }
  .moon:hover {
    transform: scale(1.1);
  }
  .hide {
    display: none;
  }
}

// Animations

@keyframes sun_rotate {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>

