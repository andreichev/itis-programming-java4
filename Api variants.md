# API VARIANTS FOR PRACTICE:

1) ### IDEAS API:
    - model:
        - user (firstName, lastName, ideas)
        - idea (name, description, likes, comments)
        - comment (idea, text, author)
     - requests:
        - registration, authorization
        - CRUD for ideas, comments

2) ### CAR PARKING API:
    - model:
        - user (firstName, lastName, money)
        - carEntry (parking, user, model, carNumber, color, startTime, endTime)
        - parking (address, priceForHour, slotsCount)
    - requests:
        - registration, authorization (optional)
        - count of slots for parking
        - can car go out of parking?
        - park car

3) ### HOSPITAL (CINEMA, RESTAURANT, CEMETERY, ...):
    - model:
        - doctor (firstName, lastName, cabinetNumber, specialization, schedule)
        - specializations (name)
        - patient (firstName, lastName)
        - appointment (patient, schedule)
        - schedule (doctor, time)
    - requests:
        - dortor free time for week
        - make appointment

4) ### CHAT:
    - model:
        - user (name, ...)
        - chatRoom (users)
        - message (chatRoom, author, body)
    - requests:
        - registration, authorization
        - make, delete chat chatRoom
        - send, delete, edit message

5) ### ROOMS BOOKING:
    - model:
        - user (name, email, team, role)
        - team (name, users)
        - room (capacity, number)
        - booking (room, owner, team, timeSlot)
        - timeSlot (start, end)
    - requests:
        - is room free for timeSlot?
        - make, undo, booking