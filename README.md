# MusicLibrary

Music Library application keeps track of songs being played by various users in the system. There are three major entities in the system:
1. Songs
2. Users
3. Artists

Each of these entities will have 2 more attributes:
1. Instance level attribute "ID"
2. Static variable named "counter", which will be initialised with 1. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1. 

The system will have have the provision of registering users with the following attributes:
- First name
- Last name
- Contact
  - Email ID
  - Phone
- Address
  - City
  - Locality
  - State
  - Pin Code 

Once the user completes registration, the system should also capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered.

We can also add artist with the following attributes:
  - First name
  - Last name
  - List of Songs released

We will capture the following details for songs:
  - Title
  - Genre
  - Release year
  - Language
  - Total Listens

The songs should also record which artist by artist ID.

There should be another class created with the name MusicLibrary, which will keep track of the list of all users, songs and artists. it will also store the user's history of playing songs. This will support the following operations:

- Register a user
- Register an artist
- Release a song
- Mark a user playing a song
- Get top 10 songs for a specific user
- Get top 10 songs overall
- Get the list of songs of a specific artist

Note:

All the operations which take any user input should do proper validation for user,artist and song identifiers. The system should always ensure that it doesn't stop because of the user giving wrong inputs.

Output Screenshot:
<img width="497" alt="1" src="https://user-images.githubusercontent.com/10265166/148801377-ee980f15-0060-49c8-ac8f-3c223d0294df.png">
<img width="494" alt="2" src="https://user-images.githubusercontent.com/10265166/148801421-301ebfb0-c21c-4214-8a7e-35353f2a38e9.png">
<img width="635" alt="3" src="https://user-images.githubusercontent.com/10265166/148801439-a141b7ca-9382-4db6-9b1c-0bcf5e506580.png">
<img width="655" alt="4" src="https://user-images.githubusercontent.com/10265166/148801459-352e2ea5-9873-4fd4-a2b5-0a5833c50803.png">
<img width="759" alt="5" src="https://user-images.githubusercontent.com/10265166/148801467-04c11707-5497-42d1-bde1-458ecb2b38f4.png">
<img width="767" alt="6" src="https://user-images.githubusercontent.com/10265166/148801488-6f66300d-d532-46b5-b79b-1a14eac9041e.png">
<img width="735" alt="7" src="https://user-images.githubusercontent.com/10265166/148801662-9a490b5d-c6f7-421b-a3e6-00f549dfd809.png">
<img width="578" alt="8" src="https://user-images.githubusercontent.com/10265166/148801586-7bb28376-e043-4f65-9390-98a18063da7c.png">
<img width="633" alt="9" src="https://user-images.githubusercontent.com/10265166/148801602-7e82061f-9807-4d1e-81b1-c2331f608704.png">
