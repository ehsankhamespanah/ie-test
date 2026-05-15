# Ticket Service (React + Java)

This project is a modernized version of the original JSP ticketing app:
- **Backend:** Java Spring Boot REST API
- **Frontend:** React (Vite)

## Run backend
```bash
mvn spring-boot:run
```
Backend starts at `http://localhost:8080`.

## Run frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend starts at `http://localhost:5173`.

## API
- `GET /api/flights` — list flights with available seats
- `POST /api/flights/book` — book tickets
