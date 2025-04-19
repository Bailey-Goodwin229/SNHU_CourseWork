# Bailey Goodwin
from contextlib import ExitStack

def show_instructions():
    #Introduces and shows instructions for the game.
    print("Welcome to the Inner Most Cave")
    print("Collect 6 items to win the game, or face self destruction.")
    print("Directions: North, West, South, East")
    print("Add to Inventory: get Item")
    print('*' * 30)
    return

def show_status(current_room, inventory, rooms):
    #Shows current room, player inventory, and what item is in the room.
    print('You are in the', current_room)
    print('Inventory:', inventory)
    if 'Item' in rooms[current_room]:
        print('This room has', rooms[current_room]['Item'])
    else:
        print('This room has no item!')
    print('*' * 30)

def main():
    # This is the main program for the game
    Inventory = []
    # Start with empty inventory(list) as you have no items in the beginning and will need to add items
    # Next is the dictionary to help move between rooms with items in the corresponding rooms
    rooms = {
        'First Step': {'East': 'Heart Room'},
        'Heart Room': {'North': 'Body Room', 'East': 'Spirit Room', 'West': 'First Step',
                       'South': 'Darkness Room', 'Item': 'Amulet of Further'},
        'Body Room': {'East': 'Mind Room', 'South': 'Heart Room', 'Item': 'Cloak of the Unknown'},
        'Mind Room': {'West': 'Body Room', 'Item': 'Book of Knowledge'},
        'Darkness Room': {'North': 'Heart Room', 'East': 'Light Room',
                          'Item': 'Boots of Darkness'},
        'Light Room': {'West': 'Darkness Room', 'Item': 'Hat of Light'},
        'Spirit Room': {'West': 'Heart Room', 'North': 'Inner Most Cave',
                        'Item': 'Staff of Wisdom'},
        'Inner Most Cave': {'South': 'Spirit Room', 'Item': 'You'}
    }
    current_room = 'First Step'
    # Staritng point
    directions = ['North', 'South', 'East', 'West']
    # Sets all available directions

    while True:

        show_status(current_room, Inventory, rooms)
        command = input('Enter your move:')
        # The code around moving between rooms
        if command in directions:
            if command in rooms[current_room]:
                current_room = rooms[current_room][command]
                if current_room == 'Inner Most Cave':
                    if len(Inventory) == 6:
                        print('You have approached the Inner Most Cave.')
                        print('You find Yourself as the final boss!')
                        print('You have moved beyond self and have grown, Game Over, you won!')
                        return
                    else:
                        print('You have approached the Inner Most Cave.')
                        print('You find Yourself as the final boss!')
                        print('You have been consumed with self, Game Over, you lost!')
                        return
            else:
                print('You cannot go that way!')
        # The code for getting an item and adding to inventory
        elif command == 'get Item':
            if 'Item' in rooms[current_room]:
                print('{} retrieved!'.format(rooms[current_room]['Item']))
                Inventory.append(rooms[current_room]['Item'])
                del rooms[current_room]['Item']
            else:
                print("No items to collect in this room")
        else:
            print('Invalid command!')

# Runs Game
show_instructions()
main()
