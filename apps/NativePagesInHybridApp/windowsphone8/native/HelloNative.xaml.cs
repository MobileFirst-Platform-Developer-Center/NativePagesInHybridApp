/**
* Copyright 2015 IBM Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Cordova.Extension.Commands;
using Newtonsoft.Json;

namespace NativePagesInHybridApp
{
    public partial class HelloNative : UserControl
    {
        public HelloNative()
        {
            InitializeComponent();
            if (WLNativePage.Data != null)
            {
                Dictionary<string, string> data = JsonConvert.DeserializeObject<Dictionary<string, string>>(WLNativePage.Data);
                NameReceivedTextBlock.Text = "Hello " + data["nameParam"];
                tb_returnValue.Text = "1234567890";
            }
            DoneButton.Click += new RoutedEventHandler(DoneButton_Click); 
        }

        void DoneButton_Click(object sender, RoutedEventArgs e)
        {
            Dictionary<string, string> data = new Dictionary<string, string>
            {
                { "phoneNumber", tb_returnValue.Text }
            };
 
            string json = JsonConvert.SerializeObject(data, Formatting.Indented);
            WLNativePage.backFromNative(this, json);
        }
    }
}
