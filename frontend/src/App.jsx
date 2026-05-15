import { useEffect, useState } from 'react';

const API_BASE = 'http://localhost:8080/api/flights';

export default function App() {
  const [flights, setFlights] = useState([]);
  const [form, setForm] = useState({ firstName: '', lastName: '', destination: '', numberOfTickets: 1 });
  const [result, setResult] = useState('');

  useEffect(() => {
    fetch(API_BASE)
      .then((res) => res.json())
      .then((data) => {
        setFlights(data);
        if (data.length > 0) {
          setForm((prev) => ({ ...prev, destination: data[0].destination }));
        }
      });
  }, []);

  const onSubmit = async (event) => {
    event.preventDefault();
    const res = await fetch(`${API_BASE}/book`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ...form, numberOfTickets: Number(form.numberOfTickets) })
    });

    const body = await res.json();
    if (!res.ok) {
      setResult(body.message ?? 'Booking failed');
      return;
    }

    setResult(`${body.message} Remaining seats: ${body.remainingSeats}`);
    const latest = await fetch(API_BASE).then((r) => r.json());
    setFlights(latest);
  };

  return (
    <main style={{ maxWidth: 700, margin: '2rem auto', fontFamily: 'Arial, sans-serif' }}>
      <h1>Ticket Service</h1>
      <p>React frontend + Java backend API</p>
      <ul>
        {flights.map((flight) => (
          <li key={flight.destination}>{flight.destination}: {flight.availableSeats} seats</li>
        ))}
      </ul>

      <form onSubmit={onSubmit}>
        <input placeholder="First Name" value={form.firstName} onChange={(e) => setForm({ ...form, firstName: e.target.value })} required />
        <input placeholder="Last Name" value={form.lastName} onChange={(e) => setForm({ ...form, lastName: e.target.value })} required />
        <select value={form.destination} onChange={(e) => setForm({ ...form, destination: e.target.value })}>
          {flights.map((f) => <option key={f.destination} value={f.destination}>{f.destination}</option>)}
        </select>
        <select value={form.numberOfTickets} onChange={(e) => setForm({ ...form, numberOfTickets: e.target.value })}>
          {[1,2,3,4,5].map((n) => <option key={n} value={n}>{n}</option>)}
        </select>
        <button type="submit">Book</button>
      </form>

      {result && <p>{result}</p>}
    </main>
  );
}
