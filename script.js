// Mood
function setMood(mood) {
  let text = "";

  if (mood === "happy") text = "🔥 Stay focused!";
  else if (mood === "sad") text = "💛 Take a short break";
  else text = "😌 Do light tasks";

  document.getElementById("suggestion").innerText = text;
}

// Task Add + Delete
function addTask() {
  let input = document.getElementById("taskInput");
  let task = input.value;

  if (task === "") return;

  let li = document.createElement("li");
  li.innerHTML = `${task} <button onclick="deleteTask(this)">❌</button>`;

  document.getElementById("taskList").appendChild(li);

  saveTasks();
  input.value = "";
}

function deleteTask(btn) {
  btn.parentElement.remove();
  saveTasks();
}

// Save
function saveTasks() {
  let tasks = [];
  document.querySelectorAll("#taskList li").forEach(li => {
    tasks.push(li.innerText.replace("❌","").trim());
  });
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

// Load
function loadTasks() {
  let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

  tasks.forEach(task => {
    let li = document.createElement("li");
    li.innerHTML = `${task} <button onclick="deleteTask(this)">❌</button>`;
    document.getElementById("taskList").appendChild(li);
  });
}

// Timer
let time = 1500;
let interval;

function startTimer() {
  clearInterval(interval);

  interval = setInterval(() => {
    let m = Math.floor(time / 60);
    let s = time % 60;

    document.getElementById("timer").innerText =
      `${m}:${s < 10 ? "0" : ""}${s}`;

    time--;

    if (time < 0) {
      clearInterval(interval);
      alert("Break time 🎉");
      time = 1500;
    }
  }, 1000);
}

// Dark Mode
function toggleDarkMode() {
  document.body.classList.toggle("dark");
}

loadTasks();