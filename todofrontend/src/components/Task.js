import React, { useEffect, useState } from 'react';
import './Task.css';

export default function Task() {
    const [description, setDescription] = useState('');
    const [priority, setPriority] = useState('');
    const [tasks, setTasks] = useState([]);

    const saveTask = (e) => {
        e.preventDefault();
        const task = { description, priority };
        console.log(task);
        fetch("http://localhost:8080/task/save", {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify(task)

        }).then(() => {
            setTasks(prevState => [...prevState, task]);
            console.log(JSON.stringify(task));
        })

    }

    const deleteTask = (taskId) => {
        fetch('http://localhost:8080/task/delete/' + taskId, {
            method: 'DELETE',
        })
            .then(res => res.text())
            .then(res => console.log(res))
        setTasks(prevState => prevState.filter(task => {
            return task.id !== taskId;
        }),
        );
    }


    useEffect(() => {
        fetch("http://localhost:8080/task/all")
            .then(res => res.json())
            .then((result) => {
                setTasks(result)
            }
            )
    }, []);



    return (
        <div>
            <form>
                Description: <input type="text" id="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)} />
                <br />
                Priority:<input type="text" id="priority"
                    value={priority}
                    onChange={(e) => setPriority(e.target.value)} />
                <input type='submit' onClick={saveTask} value='Save' />
            </form>
            <div id="all">
                {tasks.map(task => (
                    <div class="item">
                        <p>
                            <strong key={task.id}>
                                Description: {task.description}
                                priority: {task.priority}</strong>
                        </p>
                        <button onClick={() => deleteTask(task.id)}>Delete</button>
                    </div>
                ))}
            </div>
        </div>
    );
}
