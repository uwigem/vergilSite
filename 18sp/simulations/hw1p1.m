clear all; close all; clc

%Let init = [x0;y0];
init=[8;5];
%fxn = ode.m, output is odeout
tspan = linspace(0,40,2000);

%case 1
figure(1)
A=1;
B=0.2;
C=2;
D=0.25;
[t,sol] = ode45(@(t,func)hw1ode2(t,func,A,B,C,D),tspan,init);
p1 = plot(t,sol(:,1),'r'); hold on
p2 = plot(t,sol(:,2),'b');
l = legend([p1;p2],'Prey','Predators');
set(l,'Interpreter','latex')
title(['Time-based behavior of Lotka-Volterra Model','\newline','                   A=',num2str(A),', m=',num2str(B),', m=',num2str(C),', m=',num2str(D)]);%lol padding
xlabel('time'),ylabel('Population')