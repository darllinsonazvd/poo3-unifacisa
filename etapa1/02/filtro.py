# -*- coding: utf-8 -*-
"""
Created on Fri Sep  1 10:20:48 2023

@author: Pedro
"""

import pandas as pd


notas = pd.read_csv("final_data.csv")
print('Todas a empresesas mais frequentes do LinkeIn listadas',notas["Company_Name"].unique())
print('Nome da Empresa','|', 'Frequência')
print(notas['Company_Name'].value_counts())
