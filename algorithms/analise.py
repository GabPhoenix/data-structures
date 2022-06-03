# Copyright 2022 iamgabc
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#     http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import matplotlib.pyplot as plt 
import pandas as pd
import json 

tamanho = [50000, 100000, 200000]
bubble = []
merge = []
quick = []

# bubble
with open('bubble.json', 'r') as file:
    data = json.load(file)
    for key, value in data.items():
        bubble.append(value)

# merge
with open('merge.json', 'r') as file:
    data = json.load(file)
    for key, value in data.items():
        merge.append(value)

# quick
with open('quick.json', 'r') as file:
    data = json.load(file)
    for key, value in data.items():
        quick.append(value)


# grafico 
plt.plot(tamanho, bubble, color='y', label='bubblesort')
plt.plot(tamanho, merge, color='r', label='mergesort', lw=4)
plt.plot(tamanho, quick, color='b', label='quicksort')
plt.xlabel('Tamanho (em inteiros)')
plt.ylabel('Tempo (em segundos)')
plt.legend()

# tabela 
fig, ax = plt.subplots(1, 1)
data = [[], [], []]
data[0] = bubble 
data[1] = merge
data[2] = quick 
column_labels = ['50 mil', '100 mil', '200 mil']
df = pd.DataFrame(data, columns=column_labels)
ax.axis('tight')
ax.axis('off')
ax.table(cellText=df.values, colLabels=df.columns, rowLabels=['bubblesort', 'mergesort', 'quicksort'], loc='center', rowColours = ['#00ffb3'] * 3, colColours = ['#00ffb3'] * 3)
plt.show()