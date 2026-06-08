card_number = "468368746945295"


def get_card_type(card_number):
    card_type = ""

    if card_number[0] == "4":
        card_type = "Visa Cards"
    elif card_number[0] == "5":
        card_type = "MasterCard"
    elif card_number[0] == "3" and card_number[1] == "7":
        card_type = "American Express Cards"
    elif card_number[0]:
        card_type = "Discover cards"
    else:
        card_type = "Invalid Card"

    return card_type


def get_card_length(card_number):
    length = len(card_number)
    
    return length
def lhun_algorithm(card_number):
    length = len(card_number)
    digits = []
    for character in card_number:
        digits.append(int(character))

    sum_of_even_places = 0
    sum_of_odd_places = 0


    counter = 0 


    for index in range(length - 1, -1, -1):
        current_digit = digits[index]

        if counter % 2 == 1:
            doubled = current_digit * 2
            

            if doubled > 9:
                first_digit = doubled // 10
                second_digit = doubled % 10
                doubled = first_digit + second_digit
                
            sum_of_even_places += doubled
        else:
            sum_of_odd_places += current_digit
            
        counter = counter + 1


    total_sum = sum_of_even_places + sum_of_odd_places

    return total_sum

def check_card_validity(card_number):
    card_type = get_card_type(card_number)
    length = get_card_length(card_number)
    luhn_algotithm = lhun_algorithm(card_number)

    validity = "Invalid"

    if length >= 13 and length <= 16 and card_type != "Invalid Card" and luhn_algotithm % 10 == 0:
        validity = "Valid"
    return validity


print("**************************************************")
print("Credit Card Type:", get_card_type(card_number))
print("Credit Card Number:", card_number)
print("Credit Card Digit Length:", get_card_length(card_number))
print("Credit Card Validity Status:", check_card_validity)
print("**************************************************")
