# -*- coding: utf-8 -*-
"""
Created on Thu Apr 25 15:57:18 2019

@author: katek
"""

import tellurium as te
import roadrunner as rr
import pandas as pd

r = te.loada("""
    J0: $X0 -> S1; v1 * $X0
    J1: S1 -> S2; v2 * S1
    J2: S2 -> S3; v3 * S2
    J3: S3 -> S4; v4 * S3
    J4: S4 -> $X5; v5 * S4
    
  S1 = 0; S2 = 0; S3 = 0;
  S4 = 0; X0 = 10; X1 = 0;
  
   v1=4; v2=5; v3=6; v4=3; v5=3
""")

# stocastic (random) solver
r.setIntegrator('gillespie')
r.integrator.seed = '1234'
r.simulate(0, 3, 200)
r.plot()

#%%

r2 = te.loada("""
    J0: $X0 -> S1; v1 * X0 * (K/(K+S3)) 
    J1: S1 -> S2;  v2 * S1
    J3: S2 -> S3; v3 * S2
    J4: S3 -> $X1; v4 * S3      

    S1 = 0; S2 = 0; S3 = 0;
    X0 = 10; X1 = 0; 
      
    v1=10; v2=10; v3=10; v4=10; v5=10; K=1
""")
result = r2.simulate(0,2,200)
r2.plot()