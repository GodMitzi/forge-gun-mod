---
name: workspace-instructions
description: |
  Workspace-level guidance for Copilot Chat when helping with projects in this repository.
  Use this to understand the structure, build/run commands, and which project is relevant to the user request.
  
  Use when: the user asks about running, building, debugging, or modifying code in this workspace.
---

# Workspace overview

This repository contains multiple independent projects in separate folders:

- `game-quiz-bot/` — Python Discord bot that recommends free-to-play games.
- `zoom-prank-bot/` — Python Flask web app that automates joining Zoom meetings and playing audio.
- `hebrew-keyboard-fixer/` — Electron/Node.js Windows app that fixes Hebrew/English keyboard layout mix-ups.

Each project has its own `README.md` and setup instructions. When the user asks about a specific project, answer with the relevant folder and commands.

---

# How to decide which project is relevant

- If the user references **Discord**, **bot**, or **FreeToGame**, focus on `game-quiz-bot/`.
- If the user references **Zoom**, **web**, **audio**, or `run.bat`, focus on `zoom-prank-bot/`.
- If the user references **Electron**, **tray**, **keyboard layout**, or **Hebrew/English**, focus on `hebrew-keyboard-fixer/`.

---

# Common commands per project

## game-quiz-bot (Python)

```powershell
cd game-quiz-bot
python -m venv .venv
.\.venv\Scripts\Activate.ps1
pip install -r requirements.txt
python bot.py
```

## zoom-prank-bot (Python)

```powershell
cd zoom-prank-bot
pip install -r requirements.txt
python app.py
```

## hebrew-keyboard-fixer (Electron/Node.js)

```powershell
cd hebrew-keyboard-fixer
npm install
npm start
```

---

# Notes for Copilot Chat

- If the user is asking about setup issues, first check whether they are in the right project folder.
- If they mention `npm install` failing, ask them to provide the full error output and confirm they have Node.js installed.
- If they ask about starting the app automatically on Windows, point them to the `Start with Windows` setting in the Electron app (for the Hebrew keyboard fixer) or to Startup folder shortcuts.
