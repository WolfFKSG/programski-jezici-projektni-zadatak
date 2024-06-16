const name = document.getElementById('name')


document.getElementById('save').addEventListener('click',()=>{


    if(name.value === '' || name.value == null){
        alert('Department name cannot be empty')
        return
    }

    fetch('http://localhost:8000/api/department',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name.value
        })
    }).then(rsp=>{
        if (rsp.ok) {
            window.location.href='./department.html'
            return
        }

        alert(`Department creation failed(HTTP ${rsp.status}`)
    })
})
