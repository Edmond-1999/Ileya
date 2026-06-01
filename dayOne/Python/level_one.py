def split_odd_even(numbers):
    odd_numbers = []
    even_numbers = []
    
    for num in numbers:
        if num % 2 != 0:
            odd_numbers.append(num)
        else:
            even_numbers.append(num)
            
    return [odd_numbers, even_numbers]




def get_perfect_squares(numbers):
    perfect_squares = []
    
    for num in numbers:
        root = int(num ** 0.5) 
        
        if root * root == num:
            perfect_squares.append(num)
            
    return perfect_squares



def replace_non_squares(numbers):
    result = []
    
    for num in numbers:
        root = int(num ** 0.5)
        
        if root * root == num:
            result.append(num)
        else:
            result.append(-1)
            
    return result

