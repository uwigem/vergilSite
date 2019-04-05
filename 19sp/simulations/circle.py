#!/usr/bin/env python3

# Example of a monte carlo simulation to calculate the area of a circle using
# statical methods instead of needing pi

# libraries needed
import math, random, itertools
import pygame # needed for graphics

# constants used later
WHITE = (255, 255, 255) # color codes for drawing
BLUE =  (  0,   0, 255)
GREEN = (  0, 255,   0)
RED =   (255,   0,   0)
size = 1000 # square size of drawn screen

# determine if the given x,y point is inside a circle given by radius r
def isInCircle(x, y, r):
    return math.sqrt((x - r)**2 + (y - r)**2) <= r

def circleArea(radius):
    squareSide = radius*2 # length of side of the square
    pointsInside = 0 # number of points inside the circle

    # increments n forever starting at n = 1
    for n in itertools.count(1):
        # create new random point inside the square
        x = random.random()*squareSide
        y = random.random()*squareSide
        color = RED

        # if the new point is inside the circle, count it and color it green
        if (isInCircle(x, y, radius)):
            color = GREEN
            pointsInside += 1

        # calculate area from known area of square and ratio of points inside
        # circle vs total number of points
        area = pointsInside / n * squareSide**2

        # every 1000 new points print new area to terminal and update drawing
        if n % 1000 == 0:
            print("n: " + str(n) + " area: " + str(area))

            # draw new point, green for inside the circle, red for outside
            pygame.draw.circle(screen, color, (int(x*size/2), int(y*size/2)), 1)
            pygame.display.update() # refresh the screen with new point drawn

# initialise screen for drawing
pygame.init()
screen = pygame.display.set_mode((size, size))
pygame.display.set_caption("Monte Carlo Circle")
screen.fill(WHITE)
pygame.draw.circle(screen, BLUE, (size//2, size//2), size//2, 5)
pygame.draw.rect(screen, BLUE, (0, 0, size, size), 5)
pygame.display.update()

# find area of circle with given radius
circleArea(1)
