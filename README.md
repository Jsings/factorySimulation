# factorySimulation

1. System Description
A manufacturing facility assembles three different types of products, named P1,
P2, and P3. These products consist of one or more component types. There are three
different types of components, named C1, C2, and C3. Product P1 contains one component
C1, product P2 contains one component C1 and one C2, and product P3 contains one
component C1 and one C3.
Two inspectors clean and repair the components. Inspector 1 works on C1
components. Inspector 2 works on C2 and C3 components in random order. The
inspectors will never have to wait for components. There is an infinite inventory of them
always immediately available.
There are three workstations in the facility, named W1, W2, and W3, which
assemble products P1, P2, P3, respectively. After the components pass inspection they are
sent to their respective workstations. Each workstation has a buffer capacity of two
components, with one buffer available for each of the component types needed. A
product can begin being assembled only when components of all types required are
available. If all workstation buffers for a specific type of components are full, the
corresponding inspector who finished inspecting a component with the same type is
considered “blocked" until there is an opening, at which time the inspector can resume
processing and sending components of that type.

In the present mode of operation, Inspector 1 routes components C1 to the buffer
with the smallest number of components in waiting (i.e., a routing policy according to the
shortest queue). In case of a tie, W1 has the highest and W3 the lowest priority.

A simulation study is to be conducted to assess the performance of this
manufacturing facility, partly based on observed historical data of the inspectors' and
workstations' service times given in units of minutes as in the following files:

The quantities of interest are the facility “throughput" or product output per unit
time, and the probability (or proportion of time) that the inspectors remain “blocked"
(and therefore idle).
An additional objective is to possibly improve the policy that Inspector 1 follows
when delivering C1 components to the different workstations, in order to increase
throughput and/or decrease the inspectors “blocked" time.

2. Project Requirements
Conduct a complete simulation study of this manufacturing facility (in general, try
to follow the steps described in Section 1.12 of the textbook as closely as possible). You
may use any programming language you prefer to implement your simulation model. Be
thorough in explaining all steps, stating all assumptions, and specifically referring to all
equations, statistical techniques, and literature that you use. For executing the simulation,
you can use any computer platform and any language you want.

Specific requirements include statistical justification/validation of the random
aspects of the model (input modeling); steady-state estimates of the quantities of interest
accompanied by 95% confidence intervals with a width that does not exceed 20% of the
estimated values; and finally, at least one recommendation for an alternative operating
policy in the facility (with simulation results and appropriate statistical justification).
