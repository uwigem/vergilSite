# -*- coding: utf-8 -*-
"""
Created on Thu May 03 15:36:48 2018

@author: Yoshi
"""

import numpy as np
import matplotlib.pyplot as plt
import tellurium as te
import roadrunner
import antimony
import time

r = te.loada("""
# This model describes simple central dogma
    J0: -> M ; a_m
    J1: M -> ; d_m*M
    J2: M -> P ; a_p*M
    J3: P -> ; d_p*P
    
    # Parameters
    a_m = 10; d_m = 1
    a_p = 500; d_p = 0.05
    
    # Initial values
    M = 0
    P = 0
""")

#clears out any previous simulation results if it exists
r.reset() 

#the simulation is run, and is saved in "r.model", 
#but results are also stored in "result."
result = r.simulate(0,200,1000) #(start, end, timepoints)

# Find the steady-state value of Protein
P_ss = result[-1,2]

r.plot() # quick plot of model results

# Plotting using pyplot
plt.figure(1)
plt.subplot(211)
plt.plot(result[:,0], result[:,1], 'r', label = "mRNA")
plt.ylabel('Copies', fontsize='12') 
plt.xlabel('Time (hr)', fontsize='12')
plt.legend(loc=4)

plt.subplot(212)
plt.plot(result[:,0], result[:,2], 'b', label = "Protein")
plt.plot([0,200], [P_ss,P_ss], 'k--', label = "Steady-State")
plt.ylim([0,120000])
plt.ylabel('Copies', fontsize='12') 
plt.xlabel('Time (hr)', fontsize='12')
plt.legend(loc=4)
plt.tight_layout()

#%% Doing a parametric sweep using a for loop

# Investigate the input output relationship between 
# steady state Protein levels (P_ss)
# and mRNA production rate (a_m)
# or mRNA decay rate (d_m)

a_m = np.linspace(1,50,50)
#d_m = np.linspace(0.01, 10,10)
d_m = np.array([0.0001,0.001,0.01,0.1,1,10,100])
P_ss = np.zeros(len(d_m))
T_r = np.zeros(len(d_m))
count = 0
for i in d_m:
    r = te.loada("""
        J0: -> M ; a_m
        J1: M -> ; d_m*M
        J2: -> P ; a_p*M
        J3: P -> ; d_p*P
        
        # Parameters
        a_m = 10;
        a_p = 500; d_p = 0.05
        
        # Initial values
        M = 0
        P = 0
        """
        # Iterating parameters
        "d_m = " + str(i) + ";"
    )
    result = r.simulate(0,200,1000)
    
    # Find the steady-state value
    P_ss[count] = result[-1,2]
    
#    print 'd_m =',d_m[count] #verbose print of current d_m value

    count += 1
    
    plt.figure(3)
    plot = plt.semilogy(result[:,0],result[:,2],label=d_m[count-1])
    plt.legend()
    plt.xlabel("time")
    plt.ylabel("Protein")
    
    plt.figure(4)
    plot = plt.plot(result[:,0],result[:,1],label=d_m[count-1])
    plt.legend()
    plt.xlabel("time")
    plt.ylabel("mRNA")
        
#    if d_m[count-1] < 1:
#        r.plot(ylim=[0,10000000])
#    if d_m[count-1] >= 1:
#        r.plot(ylim=[0,100000])
    
    time.sleep(.25)

#%% Metabolic networks
r = te.loada("""

# Make a model of the first linear pathway

    #J0:
    
    # Parameters
    
    # Initial values
    
"""
)

a = te.loada("""

# Make a model of the second pathway with negative feedback.

    #J0:
    
    # Parameters
    
    # Initial values
    
"""
)

b = te.loada("""

# Make a model of the third complex pathway.

    #J0:
    
    # Parameters
    
    # Initial values
    
"""
)